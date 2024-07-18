package xyz.lastcoderslab.sortmaster.entity;

public class CompareMe implements Comparable<CompareMe>{

    private final String name;

    private final int score;

    private final boolean boss;

    public CompareMe(String name, int score, boolean boss) {
        this.name = name;
        this.score = score;
        this.boss = boss;
    }

    @Override
    public int compareTo(CompareMe o) {
        if(this.boss == o.isBoss()) {
            return this.score - o.getScore();
        }
        else if (this.boss) return -1;
        else return 1;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isBoss() {
        return boss;
    }

    public static CompareMeBuilder builder() {
        return new CompareMeBuilder();
    }

    public static class CompareMeBuilder {
        private String name;
        private int score;
        private boolean boss;

        public CompareMeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CompareMeBuilder score(int score) {
            this.score = score;
            return this;
        }

        public CompareMeBuilder boss(boolean boss) {
            this.boss = boss;
            return this;
        }

        public CompareMe build() {
            return new CompareMe(name, score, boss);
        }
    }

    @Override
    public String toString() {
        return "CompareMe{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", boss=" + boss +
                '}';
    }
}
