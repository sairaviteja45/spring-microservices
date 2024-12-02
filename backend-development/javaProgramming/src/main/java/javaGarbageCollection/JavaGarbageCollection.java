package javaGarbageCollection;

class JavaGarbageCollection {

    /** 1.REQUESTING GARBAGE COLLECTOR */
    public static void requestingGarbageCollector(){
        /* Request Garbage Collection. */
        System.gc();

        /* Your Application Logic Here. */
    }

    /** 2.GARBAGE COLLECTOR EXAMPLE-1 */
    public static void garbageCollectorExample1() {
        /* Create a Large Number of Objects. */
        for (int a = 0; a < 1000000; a++) {
            new Object();
        }

        /* Request Garbage Collection. */
        System.gc();

        /* Print a Message. */
        System.err.println("Calling Garbage Collection. ");
    }

    /** 3.GARBAGE COLLECTOR EXAMPLE-2 */
    @Override
    protected void finalize() throws Throwable {
        try {
            System.err.println("Calling Finalize Method...");
        } finally {
            /* Ensure the super class's finalize method is called. */
            super.finalize();
        }
    }

    public static void garbageCollectorExample2() {
        JavaGarbageCollection garbageCollection = new JavaGarbageCollection();
        JavaGarbageCollection garbageCollection1 = new JavaGarbageCollection();
        JavaGarbageCollection garbageCollection2 = new JavaGarbageCollection();

        /* Make Object Eligible For Garbage Collection. */
        garbageCollection = null;

        /* Make garbageCollection1 and garbageCollection2 refer to the same object. */
        garbageCollection1 = garbageCollection2;

        /* Make JavaGarbageCollection to anonymous object For Garbage Collection. */
        new JavaGarbageCollection();

        /* Requesting Garbage Collector. */
        System.gc();

        /* Print Message Indicating GC Request. */
        System.err.println("Request For Garbage Collection Made.");

        /* Give the Garbage Collector Some Time to do its Job. */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {

        }
    }
}


