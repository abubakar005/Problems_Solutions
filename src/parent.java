 class parent {
    public void display() {
        System.out.println("chhild");
    }


     public static void main(String[] args) {
         parent p = new child();
         child c = (child) p;
         c.display();
         c.tryme();
     }
}

 class child extends parent{
     public void display() {
        System.out.println("chhild");
     }

     public void tryme() {
         System.out.println("tryme");
     }
 }


