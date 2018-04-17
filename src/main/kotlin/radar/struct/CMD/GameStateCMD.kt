package radar.struct.CMD

import com.badlogic.gdx.math.Vector2
import radar.GameListener
import radar.register
import radar.struct.Actor
import radar.struct.Bunch
import radar.struct.NetGuidCacheObject
import radar.util.debugln

object GameStateCMD : GameListener
{
  init
  {
    register(this)
  }

  override fun onGameOver()
  {
    SafetyZonePosition.setZero()
    SafetyZoneRadius = 0f
    SafetyZoneBeginPosition.setZero()
    SafetyZoneBeginRadius = 0f
    PoisonGasWarningPosition.setZero()
    PoisonGasWarningRadius = 0f
    RedZonePosition.setZero()
    RedZoneRadius = 0f
    TotalWarningDuration = 0f
    ElapsedWarningDuration = 0f
    TotalReleaseDuration = 0f
    ElapsedReleaseDuration = 0f
    NumJoinPlayers = 0
    NumAlivePlayers = 0
    NumAliveTeams = 0
    RemainingTime = 0
    MatchElapsedMinutes = 0
    isTeamMatch = false
  }

  var isTeamMatch = false
  var TotalWarningDuration = 0f
  var ElapsedWarningDuration = 0f
  var RemainingTime = 0
  var MatchElapsedMinutes = 0
  val SafetyZonePosition = Vector2()
  var SafetyZoneRadius = 0f
  val SafetyZoneBeginPosition = Vector2()
  var SafetyZoneBeginRadius = 0f
  val PoisonGasWarningPosition = Vector2()
  var PoisonGasWarningRadius = 0f
  val RedZonePosition = Vector2()
  var RedZoneRadius = 0f
  var TotalReleaseDuration = 0f
  var ElapsedReleaseDuration = 0f
  var NumJoinPlayers = 0
  var NumAlivePlayers = 0
  var NumAliveTeams = 0

  fun process(actor : Actor, bunch : Bunch, repObj : NetGuidCacheObject?, waitingHandle : Int, data : HashMap<String, Any?>) : Boolean
  {
    try
    {
      with(bunch) {
        when (waitingHandle)
        {
          16   ->
          {
            val GameModeClass = propertyObject()
            val b = GameModeClass
          }
          17   ->
          {
            val SpectatorClass = propertyObject()
            val b = SpectatorClass
          }
          18   ->
          {
            val bReplicatedHasBegunPlay = propertyBool()
            val b = bReplicatedHasBegunPlay
          }
          19   ->
          {
            val ReplicatedWorldTimeSeconds = propertyFloat()
            val b = ReplicatedWorldTimeSeconds
          }
          20   ->
          {
            val MatchState = propertyName()
            val b = MatchState
          }
          21   ->
          {
            val ElapsedTime = propertyInt()
            val b = ElapsedTime
          }
          22   ->
          {
            val MatchId = propertyString()
            val b = MatchId
          }
          23   ->
          {
            val MatchShortGuid = propertyString()
            val b = MatchShortGuid
          }
          24   ->
          {
            val bIsCustomGame = propertyBool()
          }
          25   ->
          {
            val bIsWinnerZombieTeam = propertyBool()
          }
          26   ->
          {
            val NumTeams = propertyInt()
            val b = NumTeams
          }
          27   ->
          {
            RemainingTime = propertyInt()
          }
          28   ->
          {
            MatchElapsedMinutes = propertyInt()
          }
          29   ->
          {//new for 3.7.27.18
            val MatchElapsedTimeSec = propertyFloat()
          }
          30   ->
          {
            val bTimerPaused = propertyBool()
            val b = bTimerPaused
          }
          31   ->
          {
            val bShowLastCircleMark = propertyBool()
          }
          32   ->
          {
            val bCanShowLastCircleMark = propertyBool()
          }
          33   ->
          {//new for 3.7.27.18
            val bCanKillerSpectate = propertyBool()
          }
          34   ->
          {
            NumJoinPlayers = propertyInt()
          }
          35   ->
          {
            NumAlivePlayers = propertyInt()
//          println(NumAlivePlayers)
          }
          36   ->
          {
            val NumAliveZombiePlayers = propertyInt()
            val b = NumAliveZombiePlayers
          }
          37   ->
          {
            NumAliveTeams = propertyInt()
          }
          38   ->
          {
            val NumStartPlayers = propertyInt()
            val b = NumStartPlayers
          }
          39   ->
          {
            val NumStartTeams = propertyInt()
            val b = NumStartTeams
          }
          40   ->
          {
            val pos = propertyVector()
            SafetyZonePosition.set(pos.x, pos.y)
          }
          41   ->
          {
            SafetyZoneRadius = propertyFloat()
          }
          42   ->
          {
            val pos = propertyVector()
            PoisonGasWarningPosition.set(pos.x, pos.y)
          }
          43   ->
          {
            PoisonGasWarningRadius = propertyFloat()
          }
          44   ->
          {
            val pos = propertyVector()
            RedZonePosition.set(pos.x, pos.y)

            val b = RedZonePosition
          }
          45   ->
          {
            RedZoneRadius = propertyFloat()
            val b = RedZoneRadius
          }
          //46   ->
          //{//LastCirclePosition
          //  
          //}
          47   ->
          {
            TotalReleaseDuration = propertyFloat()
            val b = TotalReleaseDuration
          }
          48   ->
          {
            ElapsedReleaseDuration = propertyFloat()
            val b = ElapsedReleaseDuration
          }
          49   ->
          {
            TotalWarningDuration = propertyFloat()
          }
          50   ->
          {
            ElapsedWarningDuration = propertyFloat()
          }
          51   ->
          {
            val bIsGasRelease = propertyBool()
          }
          52   ->
          {
            isTeamMatch = propertyBool()
          }
          53   ->
          {
            val bIsZombieMode = propertyBool()
          }
          54   ->
          {
            val bUseXboxUnauthorizedDevice = propertyBool()
          }
          55   ->
          {
            val pos = propertyVector()
            SafetyZoneBeginPosition.set(pos.x, pos.y)
          }
          56   ->
          {
            SafetyZoneBeginRadius = propertyFloat()
          }
          57   ->
          {
            val MatchStartType = propertyByte()
          }
          58   ->
          {
            val bShowAircraftRoute = propertyBool()
          }
          59   ->
          {
            val bIsWarMode = propertyBool()
          }
          60   ->
          {
            val GoalScore = propertyInt()
          }
          61   ->
          {//TeamScores
            return false
          }
          //62   ->
          //{
          //  val NextRespawnTimeTick = propertyUInt64()
          //}
          //63   ->
          //{
          //  val TimeLimitTick = propertyUInt64()
          //}
          //64   ->
          //{
          //  bIsTeamElimination = propertyBool()
          //}
          //65   ->
          //{
          //  bUseWarRoyaleBluezone = propertyBool()
          //}
          //66   ->
          //{
          //  bUsingSquadInTeam = propertyBool()
          //}
          //67   ->
          //{//TeamIds
          //  
          //}
          //68   ->
          //{//TeamIndices
          //  
          //}
          //69   ->
          //{//TeamLeaderNames
          //  
          //}
          else -> return ActorCMD.process(actor, bunch, repObj, waitingHandle, data)
        }
        return true
      }
    }
    catch (e : Exception)
    {
      debugln { ("GameStateCMD is throwing somewhere: $e ${e.stackTrace} ${e.message} ${e.cause}") }
    }
    return false
  }
}