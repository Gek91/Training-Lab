package traininglab.controller.utils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class WeightTableHTMLBuilder {

	public WeightTableHTMLBuilder() {
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init( p );
	}

	public String buildHTML(Map<BigDecimal, BigDecimal> values, BigDecimal rm) {

		VelocityContext context = new VelocityContext();
		context.put("percentages",
				values.keySet().stream()
					.map(x -> x.multiply(new BigDecimal(100l)).setScale(0).toString() + "%" )
					.collect(Collectors.toList())
		);
		context.put("weights", values.values());
		context.put("rm", rm.toString());

		Template template = Velocity.getTemplate("weight_table_template.html");

		StringWriter stringWriter = new StringWriter();

		template.merge(context, stringWriter);

		return stringWriter.toString();
	}
}
