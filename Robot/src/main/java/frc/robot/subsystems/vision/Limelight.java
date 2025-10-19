package frc.robot.subsystems.vision;

import edu.wpi.first.math.geometry.Pose2d;

public class Limelight {

  private final QuestNavSubsystem questNavSubsystem;

  public Limelight(QuestNavSubsystem questNavSubsystem) {
    this.questNavSubsystem = questNavSubsystem;
  }

  public Pose2d getEstimatedPose() {
    double robotYaw = questNavSubsystem.getCurrentYawDegrees();

    // Sync robot yaw to Limelight
    LimelightHelpers.SetRobotOrientation("", robotYaw, 0.0, 0.0, 0.0, 0.0, 0.0); // fix name

    // Ask Limelight for pose
    LimelightHelpers.PoseEstimate limelightMeasurement =
        LimelightHelpers.getBotPoseEstimate_wpiBlue(""); // todo: fix

    if (limelightMeasurement == null || limelightMeasurement.pose == null) {
      return new Pose2d(); // fallback: pose = zaro
    }

    return limelightMeasurement.pose;
  }
}
