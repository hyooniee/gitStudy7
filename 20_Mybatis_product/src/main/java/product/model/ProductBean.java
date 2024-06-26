package product.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	private int num;
	
	@Length(min = 3, max = 10, message = "��ǰ �̸��� �ּ� 3�ڸ� �ִ� 10�ڸ� �Դϴ�.")
	private String name;
	private String company;
	
	private int orderqty;//�ֹ�����
	
	
	
	public int getOrderqty() {
		return orderqty;
	}
	public void setOrderqty(int orderqty) {
		this.orderqty = orderqty;
	}
	@NotEmpty(message = "���� ���� ����")
	private String image;
	
	private int stock;
	
	@Min(value = 3000, message = "������ �ּ� 3000�� �̻��Դϴ�.")
	private int price;
	
	private String category;
	
	@Length(min = 5, max = 10, message = "��ǰ ������ �ּ� 5�ڸ� �ִ� 10�ڸ� �Դϴ�.")
	private String contents;
	
	private int point;
	
	private String inputdate;
	
	// �߰�
	private MultipartFile upload;
	private String upload2; // �����Ҷ� �����Ϸ��� ���ϸ�
	
	
	public ProductBean() {
		super();
		System.out.println("ProductBean() ");
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		System.out.println("setUpload()");
		System.out.println("upload:" + upload); // org.springframework.web.multipart.commons.CommonsMultipartFile@51eb1299
		
		this.upload = upload;
		if(this.upload != null) {
			System.out.println(upload.getName()); // upload
			System.out.println(upload.getOriginalFilename()); // ���ڽð�.jpg
			image = upload.getOriginalFilename(); // image = ���ڽð�.jpg
		}
	}
	public String getUpload2() {
		return upload2;
	}
	public void setUpload2(String upload2) {
		this.upload2 = upload2;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) { // name:���̴�
		System.out.println("setName()");
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		System.out.println("setImage(String image):" + image);
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	
}