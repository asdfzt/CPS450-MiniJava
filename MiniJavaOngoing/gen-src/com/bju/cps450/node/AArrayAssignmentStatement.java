/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AArrayAssignmentStatement extends PStatement
{
    private TIdentifier _identifier_;
    private PExpression _position_;
    private PExpression _value_;

    public AArrayAssignmentStatement()
    {
        // Constructor
    }

    public AArrayAssignmentStatement(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PExpression _position_,
        @SuppressWarnings("hiding") PExpression _value_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setPosition(_position_);

        setValue(_value_);

    }

    @Override
    public Object clone()
    {
        return new AArrayAssignmentStatement(
            cloneNode(this._identifier_),
            cloneNode(this._position_),
            cloneNode(this._value_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayAssignmentStatement(this);
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public PExpression getPosition()
    {
        return this._position_;
    }

    public void setPosition(PExpression node)
    {
        if(this._position_ != null)
        {
            this._position_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._position_ = node;
    }

    public PExpression getValue()
    {
        return this._value_;
    }

    public void setValue(PExpression node)
    {
        if(this._value_ != null)
        {
            this._value_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._value_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._position_)
            + toString(this._value_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._position_ == child)
        {
            this._position_ = null;
            return;
        }

        if(this._value_ == child)
        {
            this._value_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._position_ == oldChild)
        {
            setPosition((PExpression) newChild);
            return;
        }

        if(this._value_ == oldChild)
        {
            setValue((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
