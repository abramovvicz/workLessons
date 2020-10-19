package designPatterns.consumerProducer;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {

    private final URL downloadResource;

    public Downloader(String url) throws MalformedURLException {
        downloadResource = new URL(url);
    }

    InputStream getStream() throws IOException {
        return downloadResource.openStream();
    }
}
