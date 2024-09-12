package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FartSmeller extends SubsystemBase {
    private final CANSparkMax m_leftFront = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax m_leftBack = new CANSparkMax(1, MotorType.kBrushless);

    private final CANSparkMax m_rightFront = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax m_rightBack = new CANSparkMax(3, MotorType.kBrushless);
    
    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftFront, m_rightFront);

    public FartSmeller() {
        m_leftBack.follow(m_leftFront);
        m_rightBack.follow(m_rightFront);

        // So that the robot doesn't spin in circles
        m_rightFront.setInverted(true);
    }

    public void fart(double power, double direction) {
        m_drive.arcadeDrive(power, direction);
    }

    @Override
    public void periodic() {
        // TODO Auto-generated method stub
        super.periodic();
    }
}