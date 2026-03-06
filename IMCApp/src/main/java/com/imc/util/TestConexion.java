import java.sql.Connection;
import com.imc.util.ConexionDB;

public class TestConexion {

    public static void main(String[] args) {

        try {
            Connection conn = ConexionDB.getConnection();

            if(conn != null){
                System.out.println("Conexion exitosa a Oracle");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}