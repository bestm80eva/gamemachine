
package io.gamemachine.messages;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;

import io.protostuff.ByteString;
import io.protostuff.GraphIOUtil;
import io.protostuff.Input;
import io.protostuff.Message;
import io.protostuff.Output;
import io.protostuff.ProtobufOutput;

import java.io.ByteArrayOutputStream;
import io.protostuff.JsonIOUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.runtime.RuntimeSchema;

import io.gamemachine.util.LocalLinkedBuffer;


import java.nio.charset.Charset;





import org.javalite.common.Convert;
import org.javalite.activejdbc.Model;
import io.protostuff.Schema;
import io.protostuff.UninitializedMessageException;



@SuppressWarnings("unused")
public final class ObjectdbDel implements Externalizable, Message<ObjectdbDel>, Schema<ObjectdbDel>{



    public static Schema<ObjectdbDel> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static ObjectdbDel getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final ObjectdbDel DEFAULT_INSTANCE = new ObjectdbDel();
    static final String defaultScope = ObjectdbDel.class.getSimpleName();

    			public String entityId;
	    
        


    public ObjectdbDel()
    {
        
    }


	


	public static void clearModel(Model model) {
    	    	    	    	    	    	model.set("objectdb_del_entity_id",null);
    	    }
    
	public void toModel(Model model) {
    	    	    	    	
    	    	    	if (entityId != null) {
    	       	    	model.setString("objectdb_del_entity_id",entityId);
    	        		
    	}
    	    	    }
    
	public static ObjectdbDel fromModel(Model model) {
		boolean hasFields = false;
    	ObjectdbDel message = new ObjectdbDel();
    	    	    	    	    	
    	    	    	String entityIdField = model.getString("objectdb_del_entity_id");
    	    	
    	if (entityIdField != null) {
    		message.setEntityId(entityIdField);
    		hasFields = true;
    	}
    	    	    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }


	    
    public Boolean hasEntityId()  {
        return entityId == null ? false : true;
    }
        
		public String getEntityId() {
		return entityId;
	}
	
	public ObjectdbDel setEntityId(String entityId) {
		this.entityId = entityId;
		return this;	}
	
	
  
    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<ObjectdbDel> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public ObjectdbDel newMessage()
    {
        return new ObjectdbDel();
    }

    public Class<ObjectdbDel> typeClass()
    {
        return ObjectdbDel.class;
    }

    public String messageName()
    {
        return ObjectdbDel.class.getSimpleName();
    }

    public String messageFullName()
    {
        return ObjectdbDel.class.getName();
    }

    public boolean isInitialized(ObjectdbDel message)
    {
        return true;
    }

    public void mergeFrom(Input input, ObjectdbDel message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                            	case 1:
            	                	                	message.entityId = input.readString();
                	break;
                	                	
                            	            
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, ObjectdbDel message) throws IOException
    {
    	    	
    	    	if(message.entityId == null)
            throw new UninitializedMessageException(message);
    	    	
    	    	    	if(message.entityId != null)
            output.writeString(1, message.entityId, false);
    	    	
    	            	
    }

	public void dumpObject()
    {
    	System.out.println("START ObjectdbDel");
    	    	if(this.entityId != null) {
    		System.out.println("entityId="+this.entityId);
    	}
    	    	System.out.println("END ObjectdbDel");
    }
    
    public String getFieldName(int number)
    {
        switch(number)
        {
        	        	case 1: return "entityId";
        	            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
    	    	__fieldMap.put("entityId", 1);
    	    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = ObjectdbDel.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static ObjectdbDel parseFrom(byte[] bytes) {
	ObjectdbDel message = new ObjectdbDel();
	ProtobufIOUtil.mergeFrom(bytes, message, ObjectdbDel.getSchema());
	return message;
}

public static ObjectdbDel parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	ObjectdbDel message = new ObjectdbDel();
	JsonIOUtil.mergeFrom(bytes, message, ObjectdbDel.getSchema(), false);
	return message;
}

public ObjectdbDel clone() {
	byte[] bytes = this.toByteArray();
	ObjectdbDel objectdbDel = ObjectdbDel.parseFrom(bytes);
	return objectdbDel;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, ObjectdbDel.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<ObjectdbDel> schema = ObjectdbDel.getSchema();
    
	final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ProtobufOutput output = new ProtobufOutput(buffer);
    try
    {
    	schema.writeTo(output, this);
        final int size = output.getSize();
        ProtobufOutput.writeRawVarInt32Bytes(out, size);
        final int msgSize = LinkedBuffer.writeTo(out, buffer);
        assert size == msgSize;
        
        buffer.clear();
        return out.toByteArray();
    }
    catch (IOException e)
    {
        throw new RuntimeException("Serializing to a byte array threw an IOException " + 
                "(should never happen).", e);
    }
 
}

public byte[] toProtobuf() {
	LinkedBuffer buffer = LocalLinkedBuffer.get();
	byte[] bytes = null;

	try {
		bytes = ProtobufIOUtil.toByteArray(this, ObjectdbDel.getSchema(), buffer);
		buffer.clear();
	} catch (Exception e) {
		buffer.clear();
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bytes;
}

public ByteBuf toByteBuf() {
	ByteBuf bb = Unpooled.buffer(512, 2048);
	LinkedBuffer buffer = LinkedBuffer.use(bb.array());

	try {
		ProtobufIOUtil.writeTo(buffer, this, ObjectdbDel.getSchema());
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}