package frc.robot.commands;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drive.Drive;

public class FunAutoForHCPA extends SequentialCommandGroup {

  public FunAutoForHCPA(Drive drive) {

    Pose2d AlignPose1 = new Pose2d(6.25, 4, Rotation2d.fromDegrees(-180));
    Pose2d AlignPose2 = new Pose2d(3.5, 5.5, Rotation2d.fromDegrees(-60));
    Pose2d AlignPose3 = new Pose2d(6.25, 4, Rotation2d.fromDegrees(-180));
    Pose2d AlignPose4 = new Pose2d(3.5, 2.5, Rotation2d.fromDegrees(60));

    PathConstraints constraints =
        new PathConstraints(4.7, 7.0, Units.degreesToRadians(540), Units.degreesToRadians(720));

    addCommands(
        AutoBuilder.pathfindToPose(AlignPose1, constraints, 0.0),
        DriveCommands.alignToPose(drive, () -> AlignPose1, 0.04),
        AutoBuilder.pathfindToPose(AlignPose2, constraints, 0.0),
        DriveCommands.alignToPose(drive, () -> AlignPose2, 0.04),
        AutoBuilder.pathfindToPose(AlignPose3, constraints, 0.0),
        DriveCommands.alignToPose(drive, () -> AlignPose3, 0.04),
        AutoBuilder.pathfindToPose(AlignPose4, constraints, 0.0),
        DriveCommands.alignToPose(drive, () -> AlignPose4, 0.04));
  }
}
