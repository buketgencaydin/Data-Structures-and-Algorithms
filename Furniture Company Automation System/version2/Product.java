/**
 * 
 */
package FurnitureCompany;

/**
 * @author buket
 *
 */
public class Product
{
	private String name;
	private String model;
	private String color;
	private Integer stockNumber;
	
	public Product(String name, String model, String color,Integer stockNumber)
	{
		this.name = new String(name);
		this.model = new String(model);
		this.color = new String(color);
		this.stockNumber =  Integer.valueOf(stockNumber);
 	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the stockNumber
	 */
	public Integer getStockNumber() {
		return stockNumber;
	}
	/**
	 * @param stockNumber the stockNumber to set
	 */
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
    public String toString() {
        return name + ' ' + model + ' ' + color + ' ' + stockNumber;
    }
	


}
