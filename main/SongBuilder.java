package main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SongBuilder {
	ResultSet rs;
	public SongBuilder(ResultSet rs)
	{
		this.rs = rs;
	}
	
	public File buildAsSong() throws IOException
	{
		try
		{
			String filename = rs.getString(2);
			Blob blob = rs.getBlob(3);
			InputStream in = blob.getBinaryStream();
			File temp = File.createTempFile(rs.getString(2), ".wav");
			OutputStream out = new FileOutputStream(temp);
			byte[] buff = new byte[4096];
			int len = 0;
			
			while ((len = in.read(buff)) != -1) {
			    out.write(buff, 0, len);
			}
			return temp;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return File.createTempFile("dump", ".txt");
		}
	}
	
	public Vector<Object> buildAsEntry() throws SQLException
	{
		Vector<Object> data = new Vector<Object>();
		data.add(rs.getString(2));
		return data;
	}
}
