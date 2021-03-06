/*
 * @(#)BallsJScrollBar.java 4.3.0
 * Copyleft (c) 2010 Arnaud BeLO.
 */

package fr.jugglemaster.control.ball;

import java.awt.event.AdjustmentEvent;
import fr.jugglemaster.control.ControlJFrame;
import fr.jugglemaster.control.util.ExtendedJScrollBar;
import fr.jugglemaster.user.Language;
import fr.jugglemaster.util.Constants;
import fr.jugglemaster.util.Tools;

/**
 * Description
 * 
 * @version 4.3.0
 * @author Arnaud BeLO.
 */
final public class BallsJScrollBar extends ExtendedJScrollBar {

	/**
	 * Constructs
	 * 
	 * @param objPcontrolJFrame
	 */
	public BallsJScrollBar(ControlJFrame objPcontrolJFrame) {
		super(	objPcontrolJFrame,
				Constants.bytS_BYTE_LOCAL_BALLS_TRAIL_DEFAULT_VALUE,
				1,
				Constants.bytS_BYTE_LOCAL_BALLS_MINIMUM_VALUE,
				Constants.bytS_BYTE_LOCAL_BALLS_MAXIMUM_VALUE + 1,
				5,
				Language.intS_TOOLTIP_BALLS_TRACE);
	}

	/**
	 * Method description
	 * 
	 * @see
	 * @param objPadjustmentEvent
	 */
	@Override final public void adjustmentValueChanged(AdjustmentEvent objPadjustmentEvent) {

		Tools.debug("BallsJScrollBar.adjustmentValueChanged()");
		BallActions.doAdjustBallsTrail(this.objGcontrolJFrame, (byte) objPadjustmentEvent.getValue());
	}

	final private static long	serialVersionUID	= Constants.lngS_ENGINE_VERSION_NUMBER;
}

/*
 * @(#)BallsJScrollBar.java 4.3.0
 * Copyleft (c) 2010 Arnaud BeLO.
 */
