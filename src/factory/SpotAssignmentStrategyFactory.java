package factory;

import models.SpotAssignmentStrategyType;
import strategies.RandomSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategyForType(
            SpotAssignmentStrategyType spotAssignmentStrategyType){
//        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST)){
//            return new NearestSpotAssignmentStrategy();
//        }else if (spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)){
//            return new CheapestSpotAssignmentStrategy();
//        }
        return new RandomSpotAssignmentStrategy();
    }
}
