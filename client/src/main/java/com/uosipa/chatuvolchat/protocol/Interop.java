// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Interop.proto

package com.uosipa.chatuvolchat.protocol;

public final class Interop {
  private Interop() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class MessageContainer extends
      com.google.protobuf.GeneratedMessage.ExtendableMessage<
        MessageContainer> {
    // Use MessageContainer.newBuilder() to construct.
    private MessageContainer() {
      initFields();
    }
    private MessageContainer(boolean noInit) {}
    
    private static final MessageContainer defaultInstance;
    public static MessageContainer getDefaultInstance() {
      return defaultInstance;
    }
    
    public MessageContainer getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.uosipa.chatuvolchat.protocol.Interop.internal_static_com_uosipa_chatuvolchat_protocol_MessageContainer_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.uosipa.chatuvolchat.protocol.Interop.internal_static_com_uosipa_chatuvolchat_protocol_MessageContainer_fieldAccessorTable;
    }
    
    public enum Type
        implements com.google.protobuf.ProtocolMessageEnum {
      REQUEST(0, 0),
      RESPONSE(1, 1),
      NOTIFICATION(2, 2),
      ;
      
      
      public final int getNumber() { return value; }
      
      public static Type valueOf(int value) {
        switch (value) {
          case 0: return REQUEST;
          case 1: return RESPONSE;
          case 2: return NOTIFICATION;
          default: return null;
        }
      }
      
      public static com.google.protobuf.Internal.EnumLiteMap<Type>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static com.google.protobuf.Internal.EnumLiteMap<Type>
          internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<Type>() {
              public Type findValueByNumber(int number) {
                return Type.valueOf(number)
      ;        }
            };
      
      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(index);
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.getDescriptor().getEnumTypes().get(0);
      }
      
      private static final Type[] VALUES = {
        REQUEST, RESPONSE, NOTIFICATION, 
      };
      public static Type valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }
      private final int index;
      private final int value;
      private Type(int index, int value) {
        this.index = index;
        this.value = value;
      }
      
      static {
        com.uosipa.chatuvolchat.protocol.Interop.getDescriptor();
      }
      
      // @@protoc_insertion_point(enum_scope:com.uosipa.chatuvolchat.protocol.MessageContainer.Type)
    }
    
    // required .com.uosipa.chatuvolchat.protocol.MessageContainer.Type type = 1;
    public static final int TYPE_FIELD_NUMBER = 1;
    private boolean hasType;
    private com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Type type_;
    public boolean hasType() { return hasType; }
    public com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Type getType() { return type_; }
    
    private void initFields() {
      type_ = com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Type.REQUEST;
    }
    public final boolean isInitialized() {
      if (!hasType) return false;
      if (!extensionsAreInitialized()) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      com.google.protobuf.GeneratedMessage.ExtendableMessage
        .ExtensionWriter extensionWriter = newExtensionWriter();
      if (hasType()) {
        output.writeEnum(1, getType().getNumber());
      }
      extensionWriter.writeUntil(536870912, output);
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasType()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, getType().getNumber());
      }
      size += extensionsSerializedSize();
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.uosipa.chatuvolchat.protocol.Interop.MessageContainer parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.uosipa.chatuvolchat.protocol.Interop.MessageContainer prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.ExtendableBuilder<
          com.uosipa.chatuvolchat.protocol.Interop.MessageContainer, Builder> {
      private com.uosipa.chatuvolchat.protocol.Interop.MessageContainer result;
      
      // Construct using com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.uosipa.chatuvolchat.protocol.Interop.MessageContainer();
        return builder;
      }
      
      protected com.uosipa.chatuvolchat.protocol.Interop.MessageContainer internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.uosipa.chatuvolchat.protocol.Interop.MessageContainer();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.getDescriptor();
      }
      
      public com.uosipa.chatuvolchat.protocol.Interop.MessageContainer getDefaultInstanceForType() {
        return com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.uosipa.chatuvolchat.protocol.Interop.MessageContainer build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.uosipa.chatuvolchat.protocol.Interop.MessageContainer buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.uosipa.chatuvolchat.protocol.Interop.MessageContainer buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.uosipa.chatuvolchat.protocol.Interop.MessageContainer returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.uosipa.chatuvolchat.protocol.Interop.MessageContainer) {
          return mergeFrom((com.uosipa.chatuvolchat.protocol.Interop.MessageContainer)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.uosipa.chatuvolchat.protocol.Interop.MessageContainer other) {
        if (other == com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.getDefaultInstance()) return this;
        if (other.hasType()) {
          setType(other.getType());
        }
        this.mergeExtensionFields(other);
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              int rawValue = input.readEnum();
              com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Type value = com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Type.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                setType(value);
              }
              break;
            }
          }
        }
      }
      
      
      // required .com.uosipa.chatuvolchat.protocol.MessageContainer.Type type = 1;
      public boolean hasType() {
        return result.hasType();
      }
      public com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Type getType() {
        return result.getType();
      }
      public Builder setType(com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Type value) {
        if (value == null) {
          throw new NullPointerException();
        }
        result.hasType = true;
        result.type_ = value;
        return this;
      }
      public Builder clearType() {
        result.hasType = false;
        result.type_ = com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Type.REQUEST;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.uosipa.chatuvolchat.protocol.MessageContainer)
    }
    
    static {
      defaultInstance = new MessageContainer(true);
      com.uosipa.chatuvolchat.protocol.Interop.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.uosipa.chatuvolchat.protocol.MessageContainer)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_uosipa_chatuvolchat_protocol_MessageContainer_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_uosipa_chatuvolchat_protocol_MessageContainer_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rInterop.proto\022 com.uosipa.chatuvolchat" +
      ".protocol\"\230\001\n\020MessageContainer\022E\n\004type\030\001" +
      " \002(\01627.com.uosipa.chatuvolchat.protocol." +
      "MessageContainer.Type\"3\n\004Type\022\013\n\007REQUEST" +
      "\020\000\022\014\n\010RESPONSE\020\001\022\020\n\014NOTIFICATION\020\002*\010\010\n\020\200" +
      "\200\200\200\002"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_uosipa_chatuvolchat_protocol_MessageContainer_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_uosipa_chatuvolchat_protocol_MessageContainer_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_uosipa_chatuvolchat_protocol_MessageContainer_descriptor,
              new java.lang.String[] { "Type", },
              com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.class,
              com.uosipa.chatuvolchat.protocol.Interop.MessageContainer.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
