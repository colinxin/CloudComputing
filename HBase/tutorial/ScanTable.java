package tutorial;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class ScanTable {
	public static void main(String[] args) throws IOException{
		Configuration conf=HBaseConfiguration.create();
		HTable table=new HTable(conf, "emp");
		Scan scan=new Scan();
		
		//Scan columns
		scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"));
		scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("city"));
		
		//Scan results
		ResultScanner scanner=table.getScanner(scan);
		for(Result result=scanner.next(); result!=null; result=scanner.next())
			System.out.println("Find row: "+result);
		scanner.close();
	}
}
