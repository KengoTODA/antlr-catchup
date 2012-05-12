package jp.skypencil.antlr;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

public class Statement {
	private String s;
	private String v;

	@Nonnull
	String getS() {
		return s;
	}
	void setS(@Nonnull String s) {
		this.s = checkNotNull(s);
	}

	@Nonnull
	String getV() {
		return v;
	}
	void setV(@Nonnull String v) {
		this.v = checkNotNull(v);
	}
}
