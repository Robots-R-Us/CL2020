package util.controls;

public class PIDGains {
	public final double _P;
	public final double _I;
	public final double _D;
	public final double _F;
	public final int _Izone;
	public final double _PeakOutput;
	
	public PIDGains(double _kP, double _kI, double _kD, double _kF, int _kIzone, double _kPeakOutput){
		_P = _kP;
		_I = _kI;
		_D = _kD;
		_F = _kF;
		_Izone = _kIzone;
		_PeakOutput = _kPeakOutput;
	}
}