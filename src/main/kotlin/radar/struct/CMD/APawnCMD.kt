package radar.struct.CMD

import radar.deserializer.channel.ActorChannel.Companion.visualActors
import radar.struct.Actor
import radar.struct.Archetype.Other
import radar.struct.Bunch
import radar.struct.NetGuidCacheObject
import radar.util.debugln

object APawnCMD
{
  fun process(actor : Actor, bunch : Bunch, repObj : NetGuidCacheObject?, waitingHandle : Int, data : HashMap<String, Any?>) : Boolean
  {
    try
    {
      with(bunch) {
        when (waitingHandle)
        {
          1    -> if (readBit())
          {//bHidden
            visualActors.remove(actor.netGUID)
          }
          2    -> if (!readBit())
          {// bReplicateMovement
            if (!actor.isVehicle)
              visualActors.remove(actor.netGUID)
          }
          3    -> if (readBit())
          {//bTearOff
            visualActors.remove(actor.netGUID)
          }
          6    ->
          {
            repMovement(actor)
            if (actor.type != Other)
              visualActors[actor.netGUID] = actor
          }
          16   -> propertyObject()
          17   -> readUInt16()
          18   -> propertyObject()
          else -> return ActorCMD.process(actor, bunch, repObj, waitingHandle, data)
        }
        return true
      }
    }
    catch (e : Exception)
    {
      debugln { ("APawnCMD is throwing somewhere: $e ${e.stackTrace} ${e.message} ${e.cause}") }
    }
    return false
  }
}