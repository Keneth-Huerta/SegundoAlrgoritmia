
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.BranchGroup;

public class Prueba3D {

    public Prueba3D() {

        SimpleUniverse univers = new SimpleUniverse();
        BranchGroup grupo = new BranchGroup();
        grupo.addChild(new ColorCube(0.3));
        univers.getViewingPlatform().setNominalViewingTransform();
        univers.addBranchGraph(grupo);
        
    }

    public static void main(String[] args) {
       new Prueba3D();
       
    }
}
