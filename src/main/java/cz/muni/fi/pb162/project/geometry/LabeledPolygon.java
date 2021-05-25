package cz.muni.fi.pb162.project.geometry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * class that store verteces in Map
 * @author Petr Urbanek
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable, PolygonWritable {

    public Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final Map<String, Vertex2D> sortedList;

    /**
     * Private Labal constructor
     * @param sortedList map with label and vertices
     */
    private LabeledPolygon(Map<String, Vertex2D> sortedList) {
        super(sortedList.values().toArray(new Vertex2D[0]));
        this.sortedList = sortedList;
    }

    @Override
    public void write(OutputStream os) throws IOException {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            for (Map.Entry<String, Vertex2D> entry: sortedList.entrySet()) {
                bw.write(entry.getValue().getX() + " ");
                bw.write(entry.getValue().getY() + " ");
                bw.write(entry.getKey());
                bw.newLine();
            }
            bw.flush();
        } catch (Throwable te) {
            throw new IOException("Something went wrong");
        }
    }

    @Override
    public void write(File file) throws IOException {
        try (OutputStream os = new FileOutputStream(file)) {
            write(os);
        }
    }

    /**
     * Class that is building LabaledPolygon class
     * @author Petr Urbanek
     */
    public static class Builder implements Buildable<LabeledPolygon>, PolygonReadable {

        private final Map<String, Vertex2D> sortedList = new HashMap<>();

        /**
         * add new key with vertex, if the key is already there, just replace it
         * @param label key
         * @param vert new vertex
         * @return this class
         */
        public Builder addVertex(String label, Vertex2D vert) {
            if (label == null) {
                throw new IllegalArgumentException("label");
            }
            if (vert == null) {
                throw new IllegalArgumentException("vertex");
            }
            if (sortedList.putIfAbsent(label, vert) != null) {
                sortedList.replace(label, vert);
            }
            return this;
        }

        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(sortedList);
        }

        @Override
        public Builder read(InputStream is) throws IOException {
            Map<String, Vertex2D> newVertices = new HashMap<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (br.ready()) {
                String[] oneLine = br.readLine().split(" ", 3);
                if (oneLine.length != 3) {
                    throw new IOException("Format of one line must be: \n" +
                            "x y name");
                }
                try {
                    newVertices.put(oneLine[2], new Vertex2D(
                            Double.parseDouble(oneLine[0]),
                            Double.parseDouble(oneLine[1])));

                } catch (NumberFormatException nfex) {
                    throw new IOException("Coordinates are not int/double");
                }
            }
            sortedList.putAll(newVertices);
            return this;
        }

        @Override
        public Builder read(File file) throws IOException {
            try (InputStream is = new FileInputStream(file)) {
                read(is);
            }
            return this;
        }
    }

    /**
     * git vertex by index
     * @param index vertex index, not negative number
     * @return vertex
     */
    public Vertex2D getVertex(int index){
        if (index < 0) {
            throw new IllegalArgumentException("index cannot be les than 0");
        }
        int i = index % sortedList.size();
        for (Map.Entry<String, Vertex2D> entry: sortedList.entrySet()) {
            if (i == 0) {
                return entry.getValue();
            }
            i--;
        }
        return null;
    }

    /**
     * haw many keys we have
     * @return size of our list
     */
    public int getNumVertices() {
        return sortedList.size();
    }

    /**
     * get key by vertex
     * @param label label under which the vertex is stored
     * @return key of that vertex
     */
    public Vertex2D getVertex(String label) {
        if (sortedList.get(label) == null) {
            throw new NullPointerException();
        }
        return sortedList.get(label);
    }

    @Override
    public Collection<String> getLabels() {
        Set<String> ascSet = new TreeSet<>();
        ascSet.addAll(sortedList.keySet());
        return ascSet;
    }

    @Override
    public Collection<String> getLabels(Vertex2D vertex) {
        Set<String> ascSet = new TreeSet<>();
        for (Map.Entry<String, Vertex2D> entry : sortedList.entrySet()) {
            if (entry.getValue().equals(vertex)) {
                ascSet.add(entry.getKey());
            }
        }
        return ascSet;
    }

    @Override
    public Collection<Vertex2D> getSortedVertices() {
        Collection<Vertex2D> ascSet = new TreeSet<>();
        ascSet.addAll(sortedList.values());
        return ascSet;
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        Collection<Vertex2D> ascSet = new TreeSet<>(comparator);
        ascSet.addAll(sortedList.values());
        return ascSet;
    }

    /**
     * Find all duplicates in our list
     * @return duplicates
     */
    public Collection<Vertex2D> duplicateVertices() {
        Collection<Vertex2D> duplicateVertices = new TreeSet<>();
        Set<Vertex2D> allVertices = new TreeSet<>();
        for (Map.Entry<String, Vertex2D> entry : sortedList.entrySet()) {
            if (!allVertices.add(entry.getValue())) {
                duplicateVertices.add(entry.getValue());
            }
        }
        return duplicateVertices;
    }

    public void writeJson(OutputStream os) {
        String json = gson.toJson(sortedList);
        System.out.println(json);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        try {
            bw.write(json);
            bw.close();
        } catch (Throwable te) {
            throw new IllegalArgumentException("bad argument");
        }
    }
}
