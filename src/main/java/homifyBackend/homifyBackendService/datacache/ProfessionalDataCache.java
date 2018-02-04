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

public class ProfessionalDataCache implements Cache<Long, Professional> {
    @Nullable
    @Override
    public Professional getIfPresent(Object o) {
        return null;
    }

    @Override
    public Professional get(Long aLong, Callable<? extends Professional> callable) throws ExecutionException {
        return null;
    }

    @Override
    public ImmutableMap<Long, Professional> getAllPresent(Iterable<?> iterable) {
        return null;
    }

    @Override
    public void put(Long aLong, Professional professional) {

    }

    @Override
    public void putAll(Map<? extends Long, ? extends Professional> map) {

    }

    @Override
    public void invalidate(Object o) {

    }

    @Override
    public void invalidateAll(Iterable<?> iterable) {

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
