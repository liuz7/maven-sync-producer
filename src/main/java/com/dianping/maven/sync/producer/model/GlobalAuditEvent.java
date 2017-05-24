package com.dianping.maven.sync.producer.model;

/**
 * Created by georgeliu on 2017/5/24.
 */

/*{
        "nodeId": "A2B55D21-15617890-5A66DD32-65766F46-DA519549",
        "initiator": "anonymous/172.24.96.50",
        "audit": {
            "domain": "repository.asset",
            "type": "created",
            "context": "com/facebook/swift/swift-idl-parser/0.16.0-mt-SNAPSHOT/maven-metadata.xml",
            "attributes": {
                "repository.name": "internal-snapshots",
                "format": "maven2",
                "name": "com/facebook/swift/swift-idl-parser/0.16.0-mt-SNAPSHOT/maven-metadata.xml"
            }
        }
}*/
public class GlobalAuditEvent {

    private String nodeId;
    private String initiator;
    private Audit audit;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @Override
    public String toString() {
        return "GlobalAuditEvent{" +
                "nodeId='" + nodeId + '\'' +
                ", initiator='" + initiator + '\'' +
                ", audit=" + audit +
                '}';
    }
}
