package frc.robot.subsystems;


import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;



public class IntakeSubsystem extends SubsystemBase {


    private boolean intakeActive;
    private DigitalInput beamBreakInput;
    private boolean intook;
    private CanSparkMax intakeMotorLeft;
    private CanSparkMax intakeMotorRight;

    public IntakeSubsystem(){
        intakeMotorLeft = new CanSparkMax(ID, MotorType.k);
        intakeMotorRight = new CanSparkMax(ID);
        beamBreakInput = new DigitalInput(ID);

    
   }

    public void setPower(int power){
        intakemotorLeft.set(power);
        intakemotorRight.set(power);
    }

    public Command setPowerCommand(double power) {
        return new InstantCommand(() -> {
          setPower(power);
        }, this);
      }
    
 
   @Override
   public void periodic(){
    boolean check = beamBreakInput.get();
    if(check){
        setPower(0);
        System.out.println("intook");
        intook = true;
    }
    else{
        intook = false;
    }

   }
}
