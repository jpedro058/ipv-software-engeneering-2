package com.es2.memento;

import java.util.ArrayList;

public class BackupService {
    private Server server;
    private ArrayList<Memento> snapshots;

    public BackupService(Server server) {
        this.server = server;
        this.snapshots = new ArrayList<>();
    }

    public void takeSnapshot() {
        Memento snapshot = server.backup();
        snapshots.add(snapshot);
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {
        if (snapshotNumber < 0 || snapshotNumber >= snapshots.size()) {
            throw new NotExistingSnapshotException("Snapshot doesn't exist: " + snapshotNumber);
        }
        Memento snapshot = snapshots.get(snapshotNumber);
        server.restore(snapshot);
    }
}
