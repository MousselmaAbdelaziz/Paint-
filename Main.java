
package Paint_New_Project;

public class Main  {

    
    public static void main(String[] args) {
        Model m = new Model();
        Vue v = new Vue();
        Controller c = new Controller(m,v);
        c.initConttroller();
    }
    
}

