import java.sql.SQLException;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;

import com.sky.utils.C3P0Utils;

public class Test {

	public static void main(String[] args) throws SQLException {
		QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into products (id,name,price,category) values(?,?,?,?)";
		Object[][] objects =new Object[100][];
		for (int i = 0; i < 100; i++) {
			objects[i]=new Object[] {i*new Random().nextInt(5),230+i+"",40*i,"=分2类="+i};
		}
		queryRunner.batch(sql, objects);
	}
}
