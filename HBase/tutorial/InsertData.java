package tutorial;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class InsertData {
	
	public static void main(String[] args) throws IOException{
		Configuration conf=HBaseConfiguration.create();
		//Instantiate an HTable
		HTable hTable=new HTable(conf, "emp");
		//Create a Put operation for the specified row
		Put p=new Put(Bytes.toBytes("row1"));
		//For each column to be inserted, execute add()
		//Parameter(Column family, Qualifier, Value)
		p.add(Bytes.toBytes("personal"), Bytes.toBytes("name"), Bytes.toBytes("Colin"));
		p.add(Bytes.toBytes("personal"), Bytes.toBytes("planet"), Bytes.toBytes("Mars"));
		p.add(Bytes.toBytes("professional"), Bytes.toBytes("position"), Bytes.toBytes("Manager"));
		p.add(Bytes.toBytes("professional"), Bytes.toBytes("salary"), Bytes.toBytes("50000"));
		//Execute the Put operation in HTable
		hTable.put(p);
		System.out.println("data inserted");
		hTable.close();
	}
	
	
}
