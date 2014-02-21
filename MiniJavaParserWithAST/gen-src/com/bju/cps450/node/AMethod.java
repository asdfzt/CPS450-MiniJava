/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AMethod extends PMethod
{
    private PType _type_;
    private TIdentifier _identifier_;
    private final LinkedList<PArgument> _argument_ = new LinkedList<PArgument>();
    private final LinkedList<PVariable> _variable_ = new LinkedList<PVariable>();
    private final LinkedList<PStatement> _statement_ = new LinkedList<PStatement>();

    public AMethod()
    {
        // Constructor
    }

    public AMethod(
        @SuppressWarnings("hiding") PType _type_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<?> _argument_,
        @SuppressWarnings("hiding") List<?> _variable_,
        @SuppressWarnings("hiding") List<?> _statement_)
    {
        // Constructor
        setType(_type_);

        setIdentifier(_identifier_);

        setArgument(_argument_);

        setVariable(_variable_);

        setStatement(_statement_);

    }

    @Override
    public Object clone()
    {
        return new AMethod(
            cloneNode(this._type_),
            cloneNode(this._identifier_),
            cloneList(this._argument_),
            cloneList(this._variable_),
            cloneList(this._statement_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethod(this);
    }

    public PType getType()
    {
        return this._type_;
    }

    public void setType(PType node)
    {
        if(this._type_ != null)
        {
            this._type_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._type_ = node;
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

    public LinkedList<PArgument> getArgument()
    {
        return this._argument_;
    }

    public void setArgument(List<?> list)
    {
        for(PArgument e : this._argument_)
        {
            e.parent(null);
        }
        this._argument_.clear();

        for(Object obj_e : list)
        {
            PArgument e = (PArgument) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._argument_.add(e);
        }
    }

    public LinkedList<PVariable> getVariable()
    {
        return this._variable_;
    }

    public void setVariable(List<?> list)
    {
        for(PVariable e : this._variable_)
        {
            e.parent(null);
        }
        this._variable_.clear();

        for(Object obj_e : list)
        {
            PVariable e = (PVariable) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._variable_.add(e);
        }
    }

    public LinkedList<PStatement> getStatement()
    {
        return this._statement_;
    }

    public void setStatement(List<?> list)
    {
        for(PStatement e : this._statement_)
        {
            e.parent(null);
        }
        this._statement_.clear();

        for(Object obj_e : list)
        {
            PStatement e = (PStatement) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._statement_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._type_)
            + toString(this._identifier_)
            + toString(this._argument_)
            + toString(this._variable_)
            + toString(this._statement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._type_ == child)
        {
            this._type_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._argument_.remove(child))
        {
            return;
        }

        if(this._variable_.remove(child))
        {
            return;
        }

        if(this._statement_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._type_ == oldChild)
        {
            setType((PType) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PArgument> i = this._argument_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PArgument) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PVariable> i = this._variable_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVariable) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PStatement> i = this._statement_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStatement) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
