import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsg.Transform3D;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();
		Geometry3D cyl = csg.cylinder3D(10, 20, 32, true);
		Geometry3D square = csg.box3D(90, 90, 1, true);
		Geometry3D diff = csg.difference3D(square, cyl);
		Geometry3D inter = csg.intersection3D(square, cyl );
		inter = csg.translate3DZ(10).transform(inter);
		var union = csg.union3D(diff, inter);
//		csg.view(diff);
		csg.view(union);
//		csg.view(inter);
	}
}
