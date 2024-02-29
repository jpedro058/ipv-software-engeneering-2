package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReusablePool {
    private static final int DEFAULT_MAX_POOL_SIZE = 10;
    private static ReusablePool instance;
    private final List<HttpURLConnection> pool;
    private final List<HttpURLConnection> inUse;
    private int maxPoolSize;

    private ReusablePool() {
        pool = Collections.synchronizedList(new ArrayList<>());
        inUse = Collections.synchronizedList(new ArrayList<>());
        maxPoolSize = DEFAULT_MAX_POOL_SIZE;
    }

    public static synchronized ReusablePool getInstance() {
        if (instance == null) {
            instance = new ReusablePool();
        }
        return instance;
    }

    public synchronized HttpURLConnection acquire() throws PoolExhaustedException, IOException {
            if (pool.isEmpty()) {
                if (inUse.size() >= maxPoolSize) {
                    throw new PoolExhaustedException("Pool is exhausted.");
                }
                // If pool is empty, create a new connection
                HttpURLConnection connection = createConnection();
                inUse.add(connection);
                return connection;
            } else {
                // If pool is not empty, reuse an existing connection
                HttpURLConnection connection = pool.remove(0);
                inUse.add(connection);
                return connection;
            }
    }

    private synchronized HttpURLConnection createConnection() throws IOException {
        URL url = new URL("http://ipv.pt"); // Replace with your URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Customize the connection as needed
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000); // Set connection timeout to 5 seconds
        connection.setReadTimeout(5000); // Set read timeout to 5 seconds
        return connection;
    }

    public synchronized void release(HttpURLConnection connection) throws ObjectNotFoundException {
                if (!inUse.contains(connection)) {
                    throw new ObjectNotFoundException("Object not found in the pool.");
                }
                pool.add(connection);
                inUse.remove(connection);
            }
    public synchronized void resetPool() {

                pool.clear();
                inUse.clear();
            }

    public synchronized void setMaxPoolSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Pool size must be greater than zero.");
        }
        maxPoolSize = size;
    }
}
