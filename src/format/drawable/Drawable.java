package format.drawable;

import format.config.DrawableConfig;

/**
 * 可绘制物基类
 */
public abstract class Drawable {
	// 绘制物起始绘制的x轴坐标
	protected int x;
	// 绘制物起始绘制的y轴坐标
	protected int y;
	// 可绘制物宽度
	protected int width = 0;
	// 可绘制物高度
	protected int height = 0;
	// 可绘制物信息
	protected String info;
	// 可绘制物的配置
	protected DrawableConfig config;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public DrawableConfig getConfig() {
		return config;
	}

	public void setConfig(DrawableConfig config) {
		this.config = config;
	}
}