// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.FartSmeller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

/** An example command that uses an example subsystem. */
public class FartCommand extends CommandBase {
  private final FartSmeller m_fartSmeller;

  private final DoubleSupplier m_powerGetter; 
  private final DoubleSupplier m_directionGetter; 

  /**
   * Creates a new FartCommand.
   *
   * @param subsystem The smeller used by this command.
   */
  public FartCommand(FartSmeller smeller, DoubleSupplier powerGetter, DoubleSupplier directionGetter) {
    m_fartSmeller = smeller;
    m_powerGetter = powerGetter;
    m_directionGetter = directionGetter;

    // Use addRequirements() here to declare 'smeller' dependencies.
    addRequirements(smeller);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_fartSmeller.fart(m_powerGetter.getAsDouble(), m_directionGetter.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
