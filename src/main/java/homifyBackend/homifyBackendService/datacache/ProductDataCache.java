package homifyBackend.homifyBackendService.datacache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import javax.annotation.Nullable;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import homifyBackend.homifyBackendService.model.Professional;

public class ProductDataCache implements Cache<Long, Professional> {
    @Nullable
    @Override
    public Professional getIfPresent(Object key) {
        return null;
    }

    @Override
    public Professional get(Long key, Callable<? extends Professional> loader) throws ExecutionException {
        return null;
    }

    @Override
    public ImmutableMap<Long, Professional> getAllPresent(Iterable<?> keys) {
        return null;
    }

    @Override
    public void put(Long key, Professional value) {

    }

    @Override
    public void putAll(Map<? extends Long, ? extends Professional> m) {

    }

    @Override
    public void invalidate(Object key) {

    }

    @Override
    public void invalidateAll(Iterable<?> keys) {

    }

    @Override
    public void invalidateAll() {

    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public CacheStats stats() {
        return null;
    }

    @Override
    public ConcurrentMap<Long, Professional> asMap() {
        return null;
    }

    @Override
    public void cleanUp() {

    }
}
