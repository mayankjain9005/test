import org.junit.Assert;
import org.junit.Test;
import com.cdk.services.DiscountService;
import com.cdk.services.DiscountServiceImpl;
public class DiscountJuint {
	@Test
	public void test(){
		DiscountService discountService = new DiscountServiceImpl();
		Assert.assertEquals(discountService.getFinalAmt("Regular", "$5000"), "$5000");
	}
}
