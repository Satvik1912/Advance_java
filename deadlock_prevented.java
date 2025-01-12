public class deadlock_prevented {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        // A helper method to enforce lock ordering
        public void bow(Friend bower) {
            Friend first, second;
            // Enforce consistent lock order based on the hash code of Friend objects
            if (System.identityHashCode(this) < System.identityHashCode(bower)) {
                first = this;
                second = bower;
            } else {
                first = bower;
                second = this;
            }

            synchronized (first) {
                synchronized (second) {
                    System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
                    bower.bowBack(this);
                }
            }
        }

        public void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        // Thread 1
        new Thread(() -> alphonse.bow(gaston)).start();

        // Thread 2
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}
