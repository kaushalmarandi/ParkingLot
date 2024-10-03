package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gateMap= new HashMap<>();
    public Optional<Gate>findById(Long gateId){
        if (gateMap.containsKey(gateId)){
            return Optional.of(gateMap.get(gateId));
        }else {
        return Optional.empty();}
    }
}
