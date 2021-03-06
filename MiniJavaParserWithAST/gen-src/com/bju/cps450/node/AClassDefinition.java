/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AClassDefinition extends PClassDefinition
{
    private TIdentifier _identifier_;
    private PExtendsClass _extendsClass_;
    private final LinkedList<PVariable> _variable_ = new LinkedList<PVariable>();
    private final LinkedList<PMethod> _method_ = new LinkedList<PMethod>();

    public AClassDefinition()
    {
        // Constructor
    }

    public AClassDefinition(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PExtendsClass _extendsClass_,
        @SuppressWarnings("hiding") List<?> _variable_,
        @SuppressWarnings("hiding") List<?> _method_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setExtendsClass(_extendsClass_);

        setVariable(_variable_);

        setMethod(_method_);

    }

    @Override
    public Object clone()
    {
        return new AClassDefinition(
            cloneNode(this._identifier_),
            cloneNode(this._extendsClass_),
            cloneList(this._variable_),
            cloneList(this._method_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassDefinition(this);
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

    public PExtendsClass getExtendsClass()
    {
        return this._extendsClass_;
    }

    public void setExtendsClass(PExtendsClass node)
    {
        if(this._extendsClass_ != null)
        {
            this._extendsClass_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._extendsClass_ = node;
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

    public LinkedList<PMethod> getMethod()
    {
        return this._method_;
    }

    public void setMethod(List<?> list)
    {
        for(PMethod e : this._method_)
        {
            e.parent(null);
        }
        this._method_.clear();

        for(Object obj_e : list)
        {
            PMethod e = (PMethod) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._method_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._extendsClass_)
            + toString(this._variable_)
            + toString(this._method_);
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

        if(this._extendsClass_ == child)
        {
            this._extendsClass_ = null;
            return;
        }

        if(this._variable_.remove(child))
        {
            return;
        }

        if(this._method_.remove(child))
        {
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

        if(this._extendsClass_ == oldChild)
        {
            setExtendsClass((PExtendsClass) newChild);
            return;
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

        for(ListIterator<PMethod> i = this._method_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMethod) newChild);
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
