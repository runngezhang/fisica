package fisica;

import org.jbox2d.common.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.dynamics.*;

import processing.core.*;

public class FBox extends FBody {
  float m_height;
  float m_width;

  public FBox(FWorld world, float width, float height){
    super();
    
    PolygonDef pd = new PolygonDef();
    pd.setAsBox(width/2.0f, height/2.0f);
    pd.density = m_density;
    pd.friction = m_friction;
    pd.restitution = m_restitution;
    pd.isSensor = m_sensor;
 
    BodyDef bd = new BodyDef();
    bd.isBullet = m_bullet;
    
    m_body = world.createBody(bd);
    m_body.createShape(pd);
    m_body.m_userData = this;
    
    m_body.setXForm(m_position, m_angle);

    m_height = height;
    m_width = width;
  }
  
  public float getHeight(){ 
    // only for FBox
    return m_height;
  }
  
  public float getWidth(){
    // only for FBox
    return m_width;
  }  
  
  public void draw(PApplet applet) {
    if (!isDrawable()) {
      return;
    }
    
    applet.pushMatrix();
    applet.rectMode(PConstants.CENTER);
    applyMatrix(applet);
    applet.rect(0, 0, getHeight(), getWidth());
    applet.popMatrix();
  }
  
}
