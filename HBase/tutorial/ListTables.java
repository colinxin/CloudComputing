package tutorial;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

//The program shows the titles of tables
public class ListTables {
	public static void main(String[] args) throws MasterNotRunningException, IOException{
		//Configuration class
		Configuration conf=HBaseConfiguration.create();
		//HBase admin class
		HBaseAdmin admin=new HBaseAdmin(conf);
		//Lists all the userspace tables and print their names
		HTableDescriptor[] tableDescriptor=admin.listTables();
		for(int i=0; i<tableDescriptor.length; i++)
			System.out.println(tableDescriptor[i].getNameAsString());
	}
}
