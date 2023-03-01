/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.account.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AccountInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3033654366951048864L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AccountInfo\",\"namespace\":\"com.example.account.avro\",\"fields\":[{\"name\":\"accountId\",\"type\":\"long\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"balance\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AccountInfo> ENCODER =
      new BinaryMessageEncoder<AccountInfo>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AccountInfo> DECODER =
      new BinaryMessageDecoder<AccountInfo>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<AccountInfo> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<AccountInfo> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AccountInfo>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this AccountInfo to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a AccountInfo from a ByteBuffer. */
  public static AccountInfo fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long accountId;
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public double balance;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AccountInfo() {}

  /**
   * All-args constructor.
   * @param accountId The new value for accountId
   * @param name The new value for name
   * @param balance The new value for balance
   */
  public AccountInfo(java.lang.Long accountId, java.lang.CharSequence name, java.lang.Double balance) {
    this.accountId = accountId;
    this.name = name;
    this.balance = balance;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return accountId;
    case 1: return name;
    case 2: return balance;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: accountId = (java.lang.Long)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: balance = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'accountId' field.
   * @return The value of the 'accountId' field.
   */
  public java.lang.Long getAccountId() {
    return accountId;
  }

  /**
   * Sets the value of the 'accountId' field.
   * @param value the value to set.
   */
  public void setAccountId(java.lang.Long value) {
    this.accountId = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'balance' field.
   * @return The value of the 'balance' field.
   */
  public java.lang.Double getBalance() {
    return balance;
  }

  /**
   * Sets the value of the 'balance' field.
   * @param value the value to set.
   */
  public void setBalance(java.lang.Double value) {
    this.balance = value;
  }

  /**
   * Creates a new AccountInfo RecordBuilder.
   * @return A new AccountInfo RecordBuilder
   */
  public static com.example.account.avro.AccountInfo.Builder newBuilder() {
    return new com.example.account.avro.AccountInfo.Builder();
  }

  /**
   * Creates a new AccountInfo RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AccountInfo RecordBuilder
   */
  public static com.example.account.avro.AccountInfo.Builder newBuilder(com.example.account.avro.AccountInfo.Builder other) {
    return new com.example.account.avro.AccountInfo.Builder(other);
  }

  /**
   * Creates a new AccountInfo RecordBuilder by copying an existing AccountInfo instance.
   * @param other The existing instance to copy.
   * @return A new AccountInfo RecordBuilder
   */
  public static com.example.account.avro.AccountInfo.Builder newBuilder(com.example.account.avro.AccountInfo other) {
    return new com.example.account.avro.AccountInfo.Builder(other);
  }

  /**
   * RecordBuilder for AccountInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AccountInfo>
    implements org.apache.avro.data.RecordBuilder<AccountInfo> {

    private long accountId;
    private java.lang.CharSequence name;
    private double balance;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.account.avro.AccountInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.accountId)) {
        this.accountId = data().deepCopy(fields()[0].schema(), other.accountId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.balance)) {
        this.balance = data().deepCopy(fields()[2].schema(), other.balance);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing AccountInfo instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.account.avro.AccountInfo other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.accountId)) {
        this.accountId = data().deepCopy(fields()[0].schema(), other.accountId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.balance)) {
        this.balance = data().deepCopy(fields()[2].schema(), other.balance);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'accountId' field.
      * @return The value.
      */
    public java.lang.Long getAccountId() {
      return accountId;
    }

    /**
      * Sets the value of the 'accountId' field.
      * @param value The value of 'accountId'.
      * @return This builder.
      */
    public com.example.account.avro.AccountInfo.Builder setAccountId(long value) {
      validate(fields()[0], value);
      this.accountId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'accountId' field has been set.
      * @return True if the 'accountId' field has been set, false otherwise.
      */
    public boolean hasAccountId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'accountId' field.
      * @return This builder.
      */
    public com.example.account.avro.AccountInfo.Builder clearAccountId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.example.account.avro.AccountInfo.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.example.account.avro.AccountInfo.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'balance' field.
      * @return The value.
      */
    public java.lang.Double getBalance() {
      return balance;
    }

    /**
      * Sets the value of the 'balance' field.
      * @param value The value of 'balance'.
      * @return This builder.
      */
    public com.example.account.avro.AccountInfo.Builder setBalance(double value) {
      validate(fields()[2], value);
      this.balance = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'balance' field has been set.
      * @return True if the 'balance' field has been set, false otherwise.
      */
    public boolean hasBalance() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'balance' field.
      * @return This builder.
      */
    public com.example.account.avro.AccountInfo.Builder clearBalance() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AccountInfo build() {
      try {
        AccountInfo record = new AccountInfo();
        record.accountId = fieldSetFlags()[0] ? this.accountId : (java.lang.Long) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.balance = fieldSetFlags()[2] ? this.balance : (java.lang.Double) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AccountInfo>
    WRITER$ = (org.apache.avro.io.DatumWriter<AccountInfo>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AccountInfo>
    READER$ = (org.apache.avro.io.DatumReader<AccountInfo>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
