package io.github.dougmacdoug.cmcq;

import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.ObjectLockingIndexedCollection;
import com.googlecode.cqengine.persistence.wrapping.WrappingPersistence;
import net.openhft.chronicle.map.ChronicleMap;

import java.util.Set;

/**
 *
 */
public class MemoryStore<K, T extends Identifiable<K>> {
    ChronicleMap<K, T> map;
    IndexedCollection<K> indexedCollection;
    Set<K> items;
    MemoryStore() {
        indexedCollection = new ObjectLockingIndexedCollection<K>(WrappingPersistence.aroundCollection(items));
    }

}
