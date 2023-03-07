package org.example;

import org.testng.internal.collections.Pair;
import java.util.ArrayList;
import java.util.List;

public final class Matrix {
    private List<List<Integer>> data;

    private Matrix() {
    }

    public Matrix(List<List<Integer>> matrix) {
        data = new ArrayList<>();
        for (int i = 0; i < matrix.size(); ++i) {
            data.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size(); ++j) {
                data.get(i).add(matrix.get(i).get(j));
            }
        }
    }

    public List<List<Integer>> getAsList() {
        return data;
    }

    public Matrix multiply(Matrix other) throws IllegalArgumentException {
        if (data.get(0).size() != other.data.size()) {
            throw new IllegalArgumentException("Can not multiply matrices with no matches sizes!");
        }
        Matrix ans = new Matrix();
        ans.data = new ArrayList<>();
        int partialSum;
        for (int i = 0; i < data.size(); ++i) {
            ans.data.add(new ArrayList<>());
            for (int k = 0; k < other.data.get(0).size(); ++k) {
                partialSum = 0;
                for (int j = 0; j < other.data.size(); ++j) {
                    partialSum += data.get(i).get(j) * other.data.get(j).get(k);
                }
                ans.data.get(i).add(partialSum);
            }
        }
        return ans;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Matrix)) {
            return false;
        }
        Matrix other = Matrix.class.cast(o);
        if (data.size() != other.data.size() || data.get(0).size() != other.data.get(0).size()) {
            return false;
        }
        for (int i = 0; i < data.size(); ++i) {
            for (int j = 0; j < data.get(0).size(); ++j) {
                if (!data.get(i).get(j).equals(other.data.get(i).get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public Pair<Integer, Integer> shape() {
        return new Pair<>(data.size(), data.get(0).size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[\n");
        for (List<Integer> a : data) {
            sb.append("[");
            for (Integer b : a) {
                sb.append(" " + b);
            }
            sb.append(" ]\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
