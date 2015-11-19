package tutorial;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.TableName;

public class CreateTable {
	public static void main(String[] args) throws IOException{
		//Instantiating configuration class
		Configuration conf=HBaseConfiguration.create();
		//Instantiating HbaseAdmin class, it provides an interface to manage HBase database metadata
		// e.g. use HBaseAdmin to create, drop, list, enable and disable tables
		HBaseAdmin admin=new HBaseAdmin(conf);
		//Instantiating table descriptor class
		HTableDescriptor tableDescriptor=new HTableDescriptor(TableName.valueOf("emp"));
		//Adding column families to table descriptor
		//They are column families so each of the family can contain multiple fields
		tableDescriptor.addFamily(new HColumnDescriptor("personal"));
		tableDescriptor.addFamily(new HColumnDescriptor("professional"));
		//Create table
		admin.createTable(tableDescriptor);
		System.out.println("Table created");
	}
}
