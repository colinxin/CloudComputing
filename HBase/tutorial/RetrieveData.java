package tutorial;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class RetrieveData {
	
	public static void main(String[] args) throws IOException{
		Configuration conf=HBaseConfiguration.create();
		HTable hTable=new HTable(conf, "emp");
		
		//Get class - specify row name in the constructor
		Get g=new Get(Bytes.toBytes("row1"));
		//Reading data
		Result result=hTable.get(g);
		byte[] name=result.getValue(Bytes.toBytes("personal"), Bytes.toBytes("name"));
		byte[] planet=result.getValue(Bytes.toBytes("personal"), Bytes.toBytes("planet"));
		
		//Print values
		String sname=Bytes.toString(name);
		String splanet=Bytes.toString(planet);
		System.out.println("Name: "+sname+" Planet: "+splanet);	
	}
}
