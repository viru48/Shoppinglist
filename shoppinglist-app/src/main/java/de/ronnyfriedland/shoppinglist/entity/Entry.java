package de.ronnyfriedland.shoppinglist.entity;

import java.util.UUID;

import de.ronnyfriedland.shoppinglist.entity.enums.Quantity;
import de.ronnyfriedland.shoppinglist.entity.enums.Status;

/**
 * Entity to store entries of a list.
 * 
 * @author Ronny Friedland
 */
public class Entry extends AbstractEntity {

    public static final String TABLE = "Entry";
    public static final String COL_ID = "id";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_QUANTITYVALUE = "quantityvalue";
    public static final String COL_QUANTITY = "quantity";
    public static final String COL_STATUS = "status";
    public static final String COL_IMPORTANT = "important";
    public static final String COL_IMAGE = "image";
    public static final String COL_LIST = "list";

    private String description;
    private Quantity quantity;
    private Status status;
    private Shoppinglist list;
    private Boolean important = Boolean.FALSE;
    private byte[] image;

    /**
     * Creates a new {@link Entry}.
     */
    public Entry() {
        this(UUID.randomUUID().toString());
    }

    /**
     * Creates a new {@link Entry}.
     * 
     * @param uuid
     *            the initial {@link #uuid}
     */
    public Entry(final String uuid) {
        super(uuid);
        this.status = Status.OPEN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public Shoppinglist getList() {
        return list;
    }

    public void setList(Shoppinglist list) {
        this.list = list;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = 1 == important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sbuild = new StringBuilder();
        if (getQuantity().getValue() > 0) {
            sbuild.append(getQuantity().getValue()).append(" ");
        }
        if (!(null == getQuantity().getUnit() || "".equals(getQuantity().getUnit()))) {
            sbuild.append(getQuantity().getUnit()).append(" ");
        }
        sbuild.append(getDescription());
        if (null != getImage()) {
            sbuild.append(" (*)");
        }
        return sbuild.toString();
    }
}
