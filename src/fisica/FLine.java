package fisica;

import org.jbox2d.common.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.dynamics.*;

import processing.core.*;

import java.util.ArrayList;

public class FLine extends FBody {
  Vec2 m_start;
  Vec2 m_end;

  public FLine(float x1, float y1, float x2, float y2){
    super();
    
    m_start = Fisica.screenToWorld(x1, y1);
    m_end = Fisica.screenToWorld(x2, y2);
  }

  public ShapeDef getShapeDef() {
    EdgeChainDef pd = new EdgeChainDef();
    
    pd.addVertex(m_start);
    pd.addVertex(m_end);

    pd.setIsLoop(false);

    pd.density = m_density;
    pd.friction = m_friction;
    pd.restitution = m_restitution;
    pd.isSensor = m_sensor;
    return pd;
  }
    
  public void draw(PApplet applet) {
    preDraw(applet);

    if (m_image != null ) {
      drawImage(applet);
    } else {
      Vec2 tempStart = Fisica.worldToScreen(m_start);
      Vec2 tempEnd = Fisica.worldToScreen(m_end);
      applet.line(tempStart.x, tempStart.y, tempEnd.x, tempEnd.y);
    }
    
    postDraw(applet);
  }
  
}
