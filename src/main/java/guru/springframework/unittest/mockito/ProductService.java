package guru.springframework.unittest.mockito;

public class ProductService {
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public boolean buy(Product product, int orderedQuantity) throws InsufficientProductsException {
		boolean transactionStatus=false;
		int availableQuantity = productDao.getAvailableProducts(product);
		if (orderedQuantity > availableQuantity) {
			throw new InsufficientProductsException();
		}
		productDao.orderProduct(product, orderedQuantity);
		transactionStatus=true;
		return transactionStatus;
	}

}
