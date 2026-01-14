// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.ArmSubsystem;

public class RobotContainer {

private final XboxController xboxController = new XboxController(1);
private final ArmSubsystem armSubsystem = new ArmSubsystem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
      new Trigger(xboxController::getAButton)
            .whileTrue(Commands.sequence(
              Commands.run(() -> armSubsystem.runArm(), armSubsystem))
            );
            
            new Trigger(xboxController::getBButton)
            .whileTrue(Commands.sequence(
              Commands.run(() -> armSubsystem.runArmInverse(), armSubsystem))
            );

            new Trigger(xboxController::getBButton)
            .whileTrue(Commands.sequence(
              Commands.run(() -> armSubsystem.stop(), armSubsystem))
            );


              
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
