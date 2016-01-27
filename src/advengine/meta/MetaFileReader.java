package advengine.meta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class MetaFileReader implements AutoCloseable {

	private final BufferedReader r;

	public MetaFileReader( String filename ) throws FileNotFoundException {
		final File file = new File( "./data/meta/" + filename );
		this.r = new BufferedReader( new FileReader( file ) );
	}

	public String readLine() throws IOException {
		return r.readLine();
	}

	public String[] splitReadLine() throws IOException {
		return r.readLine().split( " " );
	}

	@Override
	public void close() throws IOException {
		r.close();
	}

}
